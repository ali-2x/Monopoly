# Monopoly Game

This repository contains a simplified digital version of the classic Monopoly board game, developed in Java as part of a programming assignment for the course - Problem Solving using Object Oriented Programming in Java. The game allows players to roll dice, purchase properties, build houses, and charge rent to other players as they progress around the game board. The game concludes when one of the players runs out of money.

**Game Overview**
In this version of Monopoly, up to 4 players take turns moving around a circular game board made up of 22 cells. The game board includes 16 properties, as well as special cells like Home, Jail, Car Park, Goto Jail, Chance, and Community Chest.

**Game Rules:**
Each player starts with $10,000 and moves around the board by rolling a dice (1 to 6).
When a player lands on an unowned property, they have the option to purchase it. If they land on a property owned by another player, they must pay rent.
Rent on ordinary properties increases based on the number of houses built. Train stations and utility cells have their own rent rules.
**Special Cells:**
Home: Players receive $2000 when they pass by.
Jail: No effect when visiting, but players sent here miss one turn.
Car Park: Players in the park cannot collect rent until they leave.
Go to Jail: Sends players to Jail directly.
Chance and Community Chest: Random outcomes such as gaining or losing money or being sent to Jail.
The game continues until one player has no money left.

**Classes and Features**
This project includes several core classes that define the gameplay and rules:
Gameboard: Handles the game board and player movements. (Do not modify)
Player: Manages player details like name, money, position, and whether they are in jail or park.
PropertyCell: Represents standard properties where players can build houses and collect rent.
TrainStationPropertyCell: Represents train stations with a unique rent structure.
UtilityPropertyCell: Represents utilities where rent depends on the dice roll.
ChanceCell: Represents Chance and Community Chest cells with random outcomes.
GotoJailCell: Sends players to jail.
ParkCell: Temporarily prevents players from collecting rent.

Designed By: Dr. Kevin Wang, Lecturer at HKBU Computer Science Department
