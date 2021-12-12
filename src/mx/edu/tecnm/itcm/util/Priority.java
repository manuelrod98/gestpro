package mx.edu.tecnm.itcm.util;

/**
 *
 * @author Manuel Avila
 */
public enum Priority {
    LOW(1), HIGH(2), MIDDLE(3), IMPORTANT(4), URGENT(5);

    private int index;

    private Priority() {
    }

    private Priority(int index) {
        this.index = index;
    }
}
