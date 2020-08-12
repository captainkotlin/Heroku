package com.home.selenide2.cucumber.heroku.glue.other;

import com.home.selenide2.cucumber.heroku.glue.entities.EmailBox;
import com.home.selenide2.cucumber.heroku.glue.entities.StatusCodeEntity;
import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.cucumberexpressions.ParameterType;
import io.cucumber.cucumberexpressions.Transformer;
import io.cucumber.datatable.TableEntryTransformer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MyTypeRegistryConfigurer implements TypeRegistryConfigurer
{
    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry)
    {
        typeRegistry.defineDataTableType(new io.cucumber.datatable.DataTableType(StatusCodeEntity.class, (TableEntryTransformer<StatusCodeEntity>) map ->
        {
            String page = map.get("page");
            int statusCode = Integer.parseInt(map.get("statusCode"));
            return new StatusCodeEntity(page, statusCode);
        }));
        typeRegistry.defineParameterType(new ParameterType<>("list", ".*", List.class,
                (Transformer<List>) arg -> Arrays.stream(arg.split(",")).collect(Collectors.toList())));
        typeRegistry.defineParameterType(new ParameterType<>("emailbox", ".*", EmailBox.class, new EmailBoxTransformer()));
    }

    private static class EmailBoxTransformer implements Transformer<EmailBox>
    {
        @Override
        public EmailBox transform(String arg)
        {
            var parts = Arrays.stream(arg.split(",")).map(String::trim).toArray(String[]::new);
            return new EmailBox(parts);
        }
    }
}

