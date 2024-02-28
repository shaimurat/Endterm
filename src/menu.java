import java.util.Scanner;

public class menu {
    static boolean Menu(Player player, Weapon weapon){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n1.Move on\n2.Have a rest and eat(HP recovery)\n3.Show stats\n");
        int a=sc.nextInt();
        if(a==3){
            System.out.println(player.toString());
            System.out.println("\n"+weapon.toString());
            return true;
        }
        else if (a==2) {
            player.restoreHp(player);
            return true;
        }
        return false;
    }
}
