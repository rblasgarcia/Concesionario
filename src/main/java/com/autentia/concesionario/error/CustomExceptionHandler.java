package com.autentia.concesionario.error;

import java.util.Iterator;

import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

import org.primefaces.context.RequestContext;

public class CustomExceptionHandler extends ExceptionHandlerWrapper {

    private static final String ERR_TITLE = "Ha ocurrido un error";

    private final ExceptionHandler wrapped;

    public CustomExceptionHandler(ExceptionHandler wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public ExceptionHandler getWrapped() {
        return wrapped;
    }

    @Override
    public void handle() throws FacesException {
        final Iterator<ExceptionQueuedEvent> iterator = getUnhandledExceptionQueuedEvents().iterator();

        while (iterator.hasNext()) {
            final Throwable throwable = getExceptionFromEvent(iterator.next());

            try {
                final FacesMessage message = createMessageFromException(throwable);
                RequestContext.getCurrentInstance().showMessageInDialog(message);
            } finally {
                iterator.remove();
            }
        }
        getWrapped().handle();
    }

    private Throwable getExceptionFromEvent(final ExceptionQueuedEvent event) {
        final ExceptionQueuedEventContext context = (ExceptionQueuedEventContext)event.getSource();
        final Throwable throwable = context.getException();
        return throwable;
    }

    private FacesMessage createMessageFromException(Throwable throwable) {
        final String errorMessage = throwable.getMessage() + "(" + throwable.getClass().getName() + ")";
        final FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_FATAL, ERR_TITLE, errorMessage);
        return facesMessage;
    }

}
