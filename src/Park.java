// Создать класс Park с внутренним классом, с помощью объектов которого можно хранить информацию об аттракционах, времени их работы и стоимости.

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Park {
    Scanner sc = new Scanner(System.in);
    HashMap<String,AttractionInfo> attractions = new HashMap<>();
    AttractionInfo attractionInfo = new AttractionInfo();

    public class AttractionInfo {

        private String attractionName;
        private String attractionPrice;
        private String attractionWork;

        public String getAttractionName() {
            return attractionName;
        }

        public String getAttractionPrice() {
            return attractionPrice;
        }

        public String getAttractionWork() {
            return attractionWork;
        }

        public void setAttractionName(String attractionName) {
            this.attractionName = attractionName;
        }

        public void setAttractionPrice(String attractionPrice) {
            this.attractionPrice = attractionPrice;
        }

        public void setAttractionWork(String attractionWork) {
            this.attractionWork = attractionWork;
        }

        public void addAttraction() throws InterruptedException {
            AttractionInfo info = new AttractionInfo();
            System.out.println("Введите название аттракциона");
            info.setAttractionName(sc.nextLine());

            System.out.println("Введите время работы аттракциона");
            info.setAttractionWork(sc.nextLine());

            System.out.println("Введите стоимость аттракциона");
            info.setAttractionPrice(sc.nextLine());

            attractions.put(info.getAttractionName(),info);

            System.out.println(String.format("Добавлен аттрацкион %s, время работы %s, стоимость %s", info.getAttractionName(), info.getAttractionWork(), info.getAttractionPrice()));
            System.out.println();
            Thread.sleep(2000);
        }

        public void deleteAttraction(HashMap<String,AttractionInfo> attractions) {
            System.out.println("Введите название аттракциона, который необходимо удалить");
            String a = sc.nextLine();
            if (attractions.containsKey(a)) {
                attractions.remove(a);
                System.out.println(String.format("Аттракцион %s удалён.", a));
                System.out.println();
            }
            else {
                System.out.println("Такого аттракциона не существует.");
                System.out.println();
            }
        }
        public void getAllAttractionsInfo(HashMap<String, AttractionInfo> allAtInf) throws InterruptedException {
            for (Map.Entry<String, AttractionInfo> pair : allAtInf.entrySet()) {
                System.out.println(String.format("Название аттракциона - %s. Время работы %s. Стоимость %s.", pair.getValue().getAttractionName(), pair.getValue().getAttractionWork(), pair.getValue().getAttractionPrice()));
            }
            System.out.println();
            Thread.sleep(2000);
        }

        public void parkInfoMenu() throws InterruptedException {
            while (true) {
                System.out.println("Меню управления. Введите соответствующую цифру для проведения необходимой операции.");
                System.out.println("1 - Добавить аттракцион");
                System.out.println("2 - Удалить аттракцион");
                System.out.println("3 - Получить информацию о всех аттракционах");
                System.out.println();
                String a = sc.nextLine();

                if (a.equals("1")) {
                    attractionInfo.addAttraction();
                }
                else if (a.equals("2")) {
                    attractionInfo.deleteAttraction(attractions);
                }
                else if (a.equals("3")) {
                    attractionInfo.getAllAttractionsInfo(attractions);
                }
                else {
                    System.out.println("Введены некорректные данные");
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Park park = new Park();
        park.attractionInfo.parkInfoMenu();
    }
}
