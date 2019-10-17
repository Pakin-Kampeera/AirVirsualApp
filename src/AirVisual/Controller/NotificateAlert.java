package AirVisual.Controller;

import AirVisual.Controller.Draw.DrawNewPane;

import java.util.ArrayList;

public class NotificateAlert {
    private static int countBadge = 0;
    private static ArrayList<String> message = new ArrayList<>();

    public void show() {
        System.out.println(DrawNewPane.getPlace());
        for (int i = 0; i < DrawNewPane.getData().size(); i++) {
            if (DrawNewPane.getData().get(i) >= 0 && DrawNewPane.getData().get(i) <= 50) {
                message.add("[ " + DrawNewPane.getPlace().get(i) + " ]" + " Air quality is satisfactory and no risk.");
                countBadge++;
            } else if (DrawNewPane.getData().get(i) >= 51 && DrawNewPane.getData().get(i) <= 100) {
                message.add("[ " + DrawNewPane.getPlace().get(i) + " ]" + " Sensitive individuals should avoid outdoor activity.");
                countBadge++;
            } else if (DrawNewPane.getData().get(i) >= 101 && DrawNewPane.getData().get(i) <= 150) {
                message.add("[ " + DrawNewPane.getPlace().get(i) + " ]" + " General public and sensitive individuals in particular at risk.");
                countBadge++;
            } else if (DrawNewPane.getData().get(i) >= 151 && DrawNewPane.getData().get(i) <= 200) {
                message.add("[ " + DrawNewPane.getPlace().get(i) + " ]" + " Increased likelihood of adverse effects and aggressive.");
                countBadge++;
            } else if (DrawNewPane.getData().get(i) >= 201 && DrawNewPane.getData().get(i) <= 300) {
                message.add("[ " + DrawNewPane.getPlace().get(i) + " ]" + " General public will bre noticeably effect.");
                countBadge++;
            } else if (DrawNewPane.getData().get(i) >= 301 && DrawNewPane.getData().get(i) <= 500) {
                message.add("[ " + DrawNewPane.getPlace().get(i) + " ]" + " General public and sensitive groups are at high risk.");
                countBadge++;
            }
        }
    }

    public static int getCountBadge() {
        return countBadge;
    }

    public static void setCountBadge(int countBadge) {
        NotificateAlert.countBadge = countBadge;
    }

    public static ArrayList<String> getMessage() {
        return message;
    }
}
