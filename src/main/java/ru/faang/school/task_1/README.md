Develop an army management system in the Heroes of Might and Magic III game setting using OOP principles and collections. Your task is to create a class hierarchy for different types of creatures and heroes, as well as to manage a hero's army.

1. Create an abstract class **`Creature`** with basic characteristics such as name, level, attack, defense, speed, and quantity. Also, add the method getDamage() that returns the damage inflicted by the creature.
2. Create several subclasses such as **`Pikeman`**, **`Griffin`**, **`Swordsman`**, **`Angel`**, each of which inherits from the **`Creature`** class. Set the appropriate characteristic values for each subclass.
3. Create a class Hero with basic characteristics such as name, faction, experience, and level. In this class, implement the following methods:
    - **`addCreature(Creature creature, int quantity)`**: add creatures to the hero's army.
    - **`removeCreature(Creature creature, int quantity)`**: remove creatures from the hero's army.
    - **`getArmy()`**: get a list of all creatures in the hero's army.
4. Create a class **`Battlefield`** that will contain two heroes and their armies. In this class, implement the **`battle()`** method that will simulate a battle between two armies and return the winning hero.
5. Write a test code to verify the operation of your army management system in the Heroes of Might and Magic III setting. Create several heroes and creatures, add them to the army, and then conduct a battle between the armies.
6. All of the above should be done within the task_1 package. If additional packages are needed, create them within the task_1 package as well.