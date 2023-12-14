package Task2;

public class MagicChair implements Chair{
    public void doMagic() {
        System.out.println("*~Magic*`");
    }

    @Override
    public void sit() {
        System.out.println("Стул подарил вам ауру главного героя");
    }
}
