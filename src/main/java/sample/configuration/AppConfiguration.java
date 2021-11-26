package sample.configuration;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@EnableConfigurationProperties(value = AppConfiguration.class)
@EnableAutoConfiguration
public class AppConfiguration {
    public class AppConfinguration{

    }
    public class ListBootStrapSever{
        List<String> bootStrapSevers = new List<String>();
    }
}
