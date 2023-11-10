package mcsinos.enumerator;

public enum MenuItem {
    HAMBURGUER("Hamburguer"), FRENCH_FRIES("French fries"), SODA("Soda"), ICE_CREAM("Ice cream");

    private final String name;

    MenuItem(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
