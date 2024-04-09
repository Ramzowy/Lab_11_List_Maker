import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner in = new Scanner(System.in);

    private static   String line = "";

    private static ArrayList<String> lines = new ArrayList<>();
    public static void main(String[] args) {

        String menuPrompt = "A-Add D-Delete V-View Q-Quit: ";
        String cmd = ""; // A D V or Q
        boolean done = false;
        boolean confirmQuit = false;
        do {
            // display the current list
             displayList();
            // display the cmd menu
            // get a cmd from the user display the cmd menu in the prompt
            System.out.println();

            cmd = SafeInput.getRegExString(in,"[AaDdVvQq]" , menuPrompt);

            cmd = cmd.toUpperCase();
            //execute it

            switch (cmd) {
                case "A":
                 addList();
                    break;
                case "D":
                    // display the list with item numbers
                    // get an item number for the to delete from the user
                    // convert the item to an index --
                    deleteItem();
                    break;
                case "V":
                    displayList();
                    break;
                case "Q":
                    confirmQuit = SafeInput.getYNConfirm(in, "Are you sure you want to quit[Y/N]? ");
                    if (confirmQuit)
                    {
                      System.exit(0);
                    }
                    break;
            }
        } while (!done);
    }
    public static void displayList()
    {
        System.out.println("=========================================");
        if (lines.size() > 0)
        {
            int itemNum = 1;
            for (String l : lines)
            {
                System.out.println( itemNum + "." + l);
                itemNum++;
            }
        }
        else
        {
            System.out.println("Currently, the list_is_empty!");
        }
        System.out.println("=========================================");

    }

    public static void addList()
    {
        line = SafeInput.getNonZeroLenString(in, "Enter the new item to add to the list");
        lines.add(line);
    }

    public static void deleteItem()
    {
        int itemToDelete = 0;
        // get an item number for the item to delete from the user
        itemToDelete = SafeInput.getRangedInt(in,"Enter the number of the item to delete ",1,lines.size());
        // convert the item
        itemToDelete -= 1;
        lines.remove(itemToDelete);
    }


}