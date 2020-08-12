package com.home.selenide2.cucumber.heroku.glue.features;

import com.home.selenide2.cucumber.heroku.glue.entities.EmailBox;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.SneakyThrows;

import javax.mail.Folder;
import javax.mail.Session;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        var latestMessageBody = getLatestMessageBody(emailBox.getHost(),
                emailBox.getProtocol(),
                emailBox.getEmail(),
                emailBox.getPassword());
        var containsForgot = latestMessageBody.contains("A forgot password");
        assertTrue(containsForgot);
    }

    @SneakyThrows
    public static String getLatestMessageBody(String pop3Host, String storeType, String user, String password)
    {
        String latestMessageBody;
        // create properties field
        var properties = new Properties();
        properties.put("mail.store.protocol", "pop3");
        properties.put("mail.pop3.host", pop3Host);
        properties.put("mail.pop3.port", "995");
        properties.put("mail.pop3.starttls.enable", "true");
        Session emailSession = Session.getDefaultInstance(properties);
        // emailSession.setDebug(true);

        // create the POP3 store object and connect with the pop server
        var store = emailSession.getStore("pop3s");

        store.connect(pop3Host, user, password);

        // create the folder object and open it
        Folder emailFolder = store.getFolder("INBOX");
        emailFolder.open(Folder.READ_ONLY);

        // retrieve the messages from the folder in an array and print it
        var messages = emailFolder.getMessages();
        var latestMessage = messages[messages.length - 1];
        latestMessageBody = latestMessage.getContent().toString();
        // close the store and folder objects
        emailFolder.close(false);
        store.close();
        return latestMessageBody;
    }
}
