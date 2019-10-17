package AirVisual.Controller;

import AirVisual.Controller.Draw.DrawNewPane;

import java.util.ArrayList;

public class NotificateAlert {
    private int countBadge = 0;
    private static ArrayList<String> message = new ArrayList<>();

    public void show() {
        System.out.println(DrawNewPane.getPlace());
        for (int i = 0; i < DrawNewPane.getData().size(); i++) {
            if (DrawNewPane.getData().get(i) >= 0 && DrawNewPane.getData().get(i) <= 50) {
                message.add(DrawNewPane.getPlace().get(i) + " is safe.");
                System.out.println(DrawNewPane.getPlace().get(i) + " is safe.");
                countBadge++;
            } else if (DrawNewPane.getData().get(i) >= 51 && DrawNewPane.getData().get(i) <= 100) {
                message.add(DrawNewPane.getPlace().get(i) + " You should avoid outdoor activity.");
                System.out.println(DrawNewPane.getPlace().get(i) + " You should avoid outdoor activity.");
                countBadge++;
            } else if (DrawNewPane.getData().get(i) >= 101 && DrawNewPane.getData().get(i) <= 150) {
                message.add(DrawNewPane.getPlace().get(i) + " General public and sensitive individuals.");
                System.out.println(DrawNewPane.getPlace().get(i) + " General public and sensitive individuals.");
                countBadge++;
            } else if (DrawNewPane.getData().get(i) >= 151 && DrawNewPane.getData().get(i) <= 200) {
                message.add(DrawNewPane.getPlace().get(i) + " Increse likelihood of adverse effects and aggressive.");
                System.out.println(DrawNewPane.getPlace().get(i) + " Increse likelihood of adverse effects and aggressive.");
                countBadge++;
            } else if (DrawNewPane.getData().get(i) >= 201 && DrawNewPane.getData().get(i) <= 300) {
                message.add(DrawNewPane.getPlace().get(i) + " General public will bre noticeably effect");
                System.out.println(DrawNewPane.getPlace().get(i) + " General public will bre noticeably effect");
                countBadge++;
            } else if (DrawNewPane.getData().get(i) >= 301 && DrawNewPane.getData().get(i) <= 500) {
                message.add(DrawNewPane.getPlace().get(i) + " General public and sensitive groups are at high risk.");
                System.out.println(DrawNewPane.getPlace().get(i) + " General public and sensitive groups are at high risk.");
                countBadge++;
            }
        }
    }

    public int getCountBadge() {
        return countBadge;
    }

    public static ArrayList<String> getMessage() {
        return message;
    }

    public static void setMessage(ArrayList<String> message) {
        NotificateAlert.message = message;
    }
}
