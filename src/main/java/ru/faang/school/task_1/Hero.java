import java.util.ArrayList;

class Hero {

        private String name;
        private int fraction;
        private int exp;
        private int level;
        public Hero (String name, int fraction, int exp, int level){
                this.name = name;
                this.fraction = fraction;
                this.exp = exp;
                this.level = level;
        }


        static ArrayList<Creature> creatures = new ArrayList<>();

        public void addCreature(Creature creature, int quantity) {
                for (int i = 0; i < quantity; i++) {
                        creatures.add(i, creature);
                }
        }
        public void removeCreature(Creature creature, int quantity) {
                for (int i = 0; i < quantity; i++) {
                        creatures.remove(creature);
                }
        }

        public Creature getArmy() {
                Creature a = null;
                for (Creature s: creatures) {
                        a = s;
                }
                return a;
        }

        public String getName() {
                return name;
        }


        public int getFraction() {
                return fraction;
        }

        public int getExp() {
                return exp;
        }

        public int getLevel() {
                return level;
        }
}
