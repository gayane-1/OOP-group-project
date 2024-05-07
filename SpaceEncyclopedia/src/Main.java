import core.Converter;
import core.Star;
import core.Sun;
import measures.CivilDate;
import measures.IllegalDateException;
import ui.FirstWindow;

public class Main
{

    public static void main(String[] args)
    {
      /*  Planet earth = Planet.EARTH;
        Planet mars = Planet.MARS;
        Planet mercury = Planet.MERCURY;
        Planet jupiter = Planet.JUPITER;
        Scanner sc = new Scanner(System.in);

        boolean input = true;

        while (input)
        {
            System.out.println("Please input the date");
            int day = sc.nextInt();
            int month = sc.nextInt();
            int year = sc.nextInt();
            try
            {
                earth.calculateCoordinatesOfPlanet(new CivilDate(day, month, year));
                input = false;
            }catch (IllegalDateException e)
            {
                System.out.println("Illegal date, please try again");
            }
        }*/
        FirstWindow gui = new FirstWindow();
    }
}
