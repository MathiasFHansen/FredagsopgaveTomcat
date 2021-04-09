import java.util.List;
import java.util.Set;

public class Bruger {

    String name;
    String password;
    Set<String> huskeliste;

    public Bruger(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Set<String> getHuskeliste() {
        return huskeliste;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setHuskeliste(Set<String> huskeliste) {
        this.huskeliste = huskeliste;
    }
}
