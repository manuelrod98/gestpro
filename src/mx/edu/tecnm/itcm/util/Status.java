package mx.edu.tecnm.itcm.util;

/**
 *
 * @author Manuel Avila
 */
public enum Status {
    NOT_STARTED(4, 0.0f), STARTED(1, 25.0f), IN_PROGRESS(2, 50.0f), COMPLETED(3, 100.0f);

    private int index;
    private float percentage;

    private Status() {
    }

    private Status(int index) {
        this.index = index;
    }

    private Status(int index, float percentage) {
        this.index = index;
        this.percentage = percentage;
    }
}
