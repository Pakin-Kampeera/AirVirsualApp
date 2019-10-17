package AirVisual.Controller;

import AirVisual.Controller.Draw.DrawNewPane;

public class NotificateAlert {
    private int countBadge = 0;

    public void show() {
        System.out.println(DrawNewPane.getPlace());
        for (int i = 0; i < DrawNewPane.getData().size(); i++) {
            if (DrawNewPane.getData().get(i) >= 0 && DrawNewPane.getData().get(i) <= 50) {
                System.out.println(DrawNewPane.getPlace().get(i) + " is safe.");
                countBadge++;
            } else if (DrawNewPane.getData().get(i) >= 51 && DrawNewPane.getData().get(i) <= 100) {
                System.out.println(DrawNewPane.getPlace().get(i) + " You should avoid outdoor activity.");
                countBadge++;
            } else if (DrawNewPane.getData().get(i) >= 101 && DrawNewPane.getData().get(i) <= 150) {
                System.out.println(DrawNewPane.getPlace().get(i) + " General public and sensitive individuals.");
                countBadge++;
            } else if (DrawNewPane.getData().get(i) >= 151 && DrawNewPane.getData().get(i) <= 200) {
                System.out.println(DrawNewPane.getPlace().get(i) + " Increse likelihood of adverse effects and aggressive.");
                countBadge++;
            } else if (DrawNewPane.getData().get(i) >= 201 && DrawNewPane.getData().get(i) <= 300) {
                System.out.println(DrawNewPane.getPlace().get(i) + " General public will bre noticeably effect");
                countBadge++;
            } else if (DrawNewPane.getData().get(i) >= 301 && DrawNewPane.getData().get(i) <= 500) {
                System.out.println(DrawNewPane.getPlace().get(i) + " General public and sensitive groups are at high risk.");
                countBadge++;
            }
        }
    }

    public int getCountBadge() {
        return countBadge;
    }
}
