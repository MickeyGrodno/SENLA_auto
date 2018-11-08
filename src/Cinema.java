// Создать класс Cinema с внутренним классом, с помощью объектов которого можно хранить информацию об адресах кинотеатров, фильмах и времени начала сеансов.

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Cinema {
    Scanner sc = new Scanner(System.in);
    HashMap<String,HashMap<String,String>> allCinema = new HashMap<>();
    InfoCinema infoCinema = new InfoCinema();

    public class InfoCinema {
        private String adress;
        private HashMap<String,String> filmTime = new HashMap<>();

        public void addInfoCinema() {
            String a,b;

            System.out.println("Введите название и адрес кинотеатра");
            infoCinema.setAdress(sc.nextLine());

            allCinema.put(infoCinema.getAdress(),getFilmTime());

            for (String x = ""; !x.equalsIgnoreCase("no");){

                System.out.println("Введите название фильма.");
                a = sc.nextLine();
                System.out.println("Введите время сеансов.");
                b = sc.nextLine();

                setFilmTime(filmTime,a,b);
                allCinema.put(infoCinema.getAdress(), getFilmTime());

                System.out.println("Желаете добавить еще один фильм? Для продолжения нажмите Enter, для завершения введите No.");
                x = sc.nextLine();
            }
        }

        public void printAllInfo(HashMap<String, HashMap<String, String>> all) {

            for (Map.Entry<String, HashMap<String, String>> pair : all.entrySet()) {
                System.out.println(String.format("Кинотеатр %s.", pair.getKey()));
                HashMap<String,String> filTime = pair.getValue();
                for (Map.Entry<String,String> pair2 : filTime.entrySet()){
                    System.out.println(String.format("Название фильма %s.", pair2.getKey()));
                    System.out.println(String.format("Время начала сеансов %s", pair2.getValue()));
                    System.out.println("****");
                }
                System.out.println("-------------------------------------------------");
            }
        }

        public void cinemaMenu() {
            while (true) {
                System.out.println("Информация и кинотеатрах и киносеансах. Введите номер соответствующий пункту необходимой операции.");
                System.out.println("1 - Добавить кинотеатр.");
                System.out.println("2 - Получить информацию о кинотеатрах и киносеансах.");
                String a = sc.nextLine();
                if (a.equals("1")) {
                    infoCinema.addInfoCinema();
                }
                else if (a.equals("2")) {
                    infoCinema.printAllInfo(allCinema);
                }
                else {
                    System.out.println("Введены некорректные данные.");
                }
                System.out.println();
            }
        }

        public void setAdress(String adress) {
            this.adress = adress;
        }

        public void setFilmTime(HashMap<String, String> filmTime, String key, String value) {
            filmTime.put(key,value);
        }

        public String getAdress() {
            return adress;
        }

        public HashMap<String, String> getFilmTime() {
            return filmTime;
        }
    }

    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        cinema.infoCinema.cinemaMenu();
    }
}
