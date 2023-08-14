package enums;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Problem {

    private String name;
    private String details;
    private Severity severity;

    public Problem(String name, Severity severity) {
        this(name, null,severity);
    }

    public Problem(String name) {
        this(name, null,Severity.BlOCKER);
    }

    public void resolve(){
        System.out.println("Resolving problem '" + name + "' ... " + severity.getTimeFrame());
    }
}
