package com.maetdori.cleanarchitecture;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@ConfigurationProperties(prefix = "buckpal")
public class BuckPalConfigurationProperties {

    private long transferThreshold = Long.MAX_VALUE;
}
