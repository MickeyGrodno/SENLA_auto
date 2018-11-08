//Создать класс Department с внутренним классом, с помощью объектов которого можно хранить информацию обо всех должностях отдела и обо всех сотрудниках, когда-либо занимавших конкретную должность.


import java.util.*;

public class Department {
    Scanner sc = new Scanner(System.in);
    ArrayList<WorkersInfo> allWorkers = new ArrayList<>();
    WorkersInfo workersInfo = new WorkersInfo();

    public class WorkersInfo {
        private String position;
        private HashSet<String> workers = new HashSet<>();

        public void addPosAndWorkers() {
            WorkersInfo work = new WorkersInfo();
            String a,b;
            System.out.println("Введите название должности");
            a = sc.nextLine();
            work.setPosition(a);
            for (String x = ""; !x.equalsIgnoreCase("no");) {
                System.out.println("Введите имя сотрудника");
                b = sc.nextLine();
                work.setWorkers(b);
                System.out.println("Для добавления сотрудника нажмите Enter. Для завершения добавления введите No");
                x = sc.nextLine();
            }
            allWorkers.add(work);
        }
        public void printInfo(ArrayList<WorkersInfo> allWorkers) {
            System.out.println("Данные о должностях и сотрудниках");
            for (int i = 0; i < allWorkers.size(); i++) {
                System.out.print(String.format("Должность %s. Сотрудники", allWorkers.get(i).getPosition()));
                Iterator<String> iter = allWorkers.get(i).getWorkers().iterator();
                while (iter.hasNext()) {
                    System.out.print(" "+iter.next());
                }
                System.out.println();
                System.out.println();
            }
        }

        public void depMenu() {
            while (true) {
                System.out.println("1 - для добавления должности и сотрудников");
                System.out.println("2 - для получения информации о должностях и сотрудниках");

                String a = sc.nextLine();

                if (a.equals("1")) {
                    addPosAndWorkers();
                }
                else if(a.equals("2")) {
                    printInfo(allWorkers);
                }
                else {
                    System.out.println("Введены некорректные данные");
                }
            }
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public void setWorkers(String a) {
            workers.add(a);
        }

        public String getPosition() {
            return position;
        }

        public HashSet<String> getWorkers() {
            return workers;
        }
    }

    public static void main(String[] args) {
        Department dep = new Department();
        dep.workersInfo.depMenu();
    }
}