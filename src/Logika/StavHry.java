package Logika;

/**
 * Výčtový typ StavHry reprezentuje možné stavy hry.
 *
 * @author Dominik Hebelka
 * @version 2024-25-05
 */
public enum StavHry {
    /**
     * Hra skončila vítězstvím hráče.
     */
    VYHRA,

    /**
     * Hra skončila prohrou hráče.
     */
    PROHRA,

    /**
     * Hra stále probíhá.
     */
    HRA_BEZI
}
