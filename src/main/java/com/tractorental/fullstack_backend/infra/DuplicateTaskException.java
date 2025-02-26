package com.tractorental.fullstack_backend.infra;

public class DuplicateTaskException extends RuntimeException
{
    public DuplicateTaskException(String message)
    {
        super(message);
    }
}
