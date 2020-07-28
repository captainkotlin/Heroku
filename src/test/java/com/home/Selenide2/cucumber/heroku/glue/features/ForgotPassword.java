package com.home.Selenide2.cucumber.heroku.glue.features;

import com.home.Selenide2.cucumber.heroku.glue.entities.EmailBox;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.$;

public class ForgotPassword
{
    private EmailBox emailBox;

    @When("email box is {emailbox}")
    public void emailIsSetTo(EmailBox emailBox)
    {
        this.emailBox = emailBox;
    }

    @And("send button clicked")
    public void sendButtonClicked()
    {
        $("#email").setValue(emailBox.getEmail());
        $("#form_submit").click();
    }

    @Then("email is received")
    public void emeailIsReceived()
    {
        String latestMessageBody = getLatestMessageBody(emailBox.getHost(),
                emailBox.getProtocol(),
                emailBox.getEmail(),
                emailBox.getPassword());
        boolean containsForgot = latestMessageBody.contains("A forgot password");
        Assertions.assertTrue(containsForgot);
    }

    @SneakyThrows
    public static String getLatestMessageBody(String pop3Host, String storeType, String user, String password)
    {
        String latestMessageBody = null;
        // create properties field
        Properties properties = new Properties();
        properties.put("mail.store.protocol", "pop3");
        properties.put("mail.pop3.host", pop3Host);
        properties.put("mail.pop3.port", "995");
        properties.put("mail.pop3.starttls.enable", "true");
        Session emailSession = Session.getDefaultInstance(properties);
        // emailSession.setDebug(true);

        // create the POP3 store object and connect with the pop server
        Store store = emailSession.getStore("pop3s");

        store.connect(pop3Host, user, password);

        // create the folder object and open it
        Folder emailFolder = store.getFolder("INBOX");
        emailFolder.open(Folder.READ_ONLY);

        BufferedReader reader = new BufferedReader(new InputStreamReader(
                System.in));

        // retrieve the messages from the folder in an array and print it
        Message[] messages = emailFolder.getMessages();
        Message latestMessage = messages[messages.length - 1];
        latestMessageBody = latestMessage.getContent().toString();
        // close the store and folder objects
        emailFolder.close(false);
        store.close();
        return latestMessageBody;
    }
}
