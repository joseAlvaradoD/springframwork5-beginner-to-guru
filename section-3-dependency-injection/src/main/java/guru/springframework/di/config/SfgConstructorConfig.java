package guru.springframework.di.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

@ConfigurationProperties("guru")
public class SfgConstructorConfig {

    private final String username;
    private final String password;
    private final String jdbcUrl;

    @ConstructorBinding
    public SfgConstructorConfig(String username, String password, String jdbcUrl) {
        this.username = username;
        this.password = password;
        this.jdbcUrl = jdbcUrl;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }
}
