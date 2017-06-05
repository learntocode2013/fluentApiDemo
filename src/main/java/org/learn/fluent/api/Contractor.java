package org.learn.fluent.api;

import java.time.LocalDateTime;

public class Contractor
{
    public static final Contractor DEFAULT_CONTRACTOR = new Contractor("L&T",LocalDateTime.now());

    private final String _concern;
    private final LocalDateTime _validity;

    public Contractor(String concern, LocalDateTime validUntil)
    {
        _concern  = concern;
        _validity = validUntil;
    }
}
