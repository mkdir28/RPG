# RPG

Role-Playing Game that was written in Java. RPG project have 5 classes:
In Item class I have been determined usage. Depending on use item can:
  1. Increase HP in Character class 
  2. Increase Mana in Character class
  3. Increase Stamina in Character class

In Character class which store characters atributes: Stamina, Mana, HP. 
Character class have some methods for:
  1. Attacking other Character (either physically or with magic)
  2. Determining if the character is Ally or not (by either a field)
  3. Callying an ally to help (if there is one)
  4. Using an Item class.
Every Character also has at least one Item stored in the object. After defeat character transfers
their items to the character which defeated them.
Every physical attack decreases Stamina by 1, every Magical Attack decreases mana by 1.

In Monster class that extends Character class. This class stores the same atributes as Character and one additional: EXPtoGive.

In Status class I just checked the status: is that character ally or not and after that it counted their status.

# In RPG project: 
  First the user can determine what atributes their Character can have (user has 15 points to give between all attributes).
  Then I have been created an array of Characters and Monsters this Characer will encounter. 
  If the encountered creature is a foe - user may choose to attack it.If the encountered creature is an ally, 
  user can later on call upon it for help. Users objective is to defeat every foe. 
  The game is lost if the users Character will be defeated. If the users character gathers more that 5 EXP points from defeated foes, 
  the Character can increasetheir chosen attribute by 5.
