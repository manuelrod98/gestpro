package mx.edu.tecnm.itcm.util;

/**
 *
 * @author Manuel Avila
 */
public enum Role {
    PROJECT_MANAGER(1),
    DEVELOPER(2);

    private int accesLevel;

    private Role() {
    }

    private Role(int accesLevel) {
        this.accesLevel = accesLevel;
    }
}
