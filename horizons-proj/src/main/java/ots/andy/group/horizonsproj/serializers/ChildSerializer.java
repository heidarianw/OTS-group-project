package ots.andy.group.horizonsproj.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import ots.andy.group.horizonsproj.entities.Child;

import java.io.IOException;

public class ChildSerializer extends StdSerializer<Child> {

    public ChildSerializer() {
        this(null);
    }

    public ChildSerializer(Class<Child> t) {
        super(t);
    }

    @Override
    public void serialize(Child child, JsonGenerator jgen, SerializerProvider provider)
                throws IOException, JsonProcessingException {

        jgen.writeStartObject();
        jgen.writeNumberField("id", child.getId());
        jgen.writeStringField("first", child.getFirst());
        jgen.writeStringField("last", child.getLast());
        jgen.writeNumberField("age", child.getAge());
        jgen.writeBooleanField("monday", child.isMonday());
        jgen.writeBooleanField("tuesday", child.isThursday());
        jgen.writeBooleanField("wednesday", child.isWednesday());
        jgen.writeBooleanField("thursday", child.isThursday());
        jgen.writeBooleanField("friday", child.isFriday());
        jgen.writeBooleanField("saturday", child.isSaturday());
        jgen.writeBooleanField("sunday", child.isSunday());
        jgen.writeObjectField("status", child.getStatus());
        jgen.writeObjectField("daycare", child.getDaycare());
        jgen.writeObjectField("personality", child.getPersonality());
        jgen.writeStringField("photo", child.getPhoto());
        jgen.writeObjectField("allergySet", child.getAllergySet());
        jgen.writeEndObject();
    }
}
