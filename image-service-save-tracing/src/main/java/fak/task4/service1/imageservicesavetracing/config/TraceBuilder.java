package fak.task4.service1.imageservicesavetracing.config;

import fak.task4.service1.imageservicesavetracing.ImageServiceSaveTracingApplication;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Scope;
import org.slf4j.MDC;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class TraceBuilder {

    private Tracer tracer;

    public TraceBuilder(OpenTelemetry openTelemetry) {
        this.tracer = this.tracer = openTelemetry.getTracer(ImageServiceSaveTracingApplication.class.getName());
    }

    public void waitFor(String className,String spanName){
        Span span = tracer.spanBuilder(className + " " +spanName + " ist called!").startSpan();
        try(Scope scope = span.makeCurrent()) {

        }finally {
            MDC.clear();
            span.end();
        }
    }

}
