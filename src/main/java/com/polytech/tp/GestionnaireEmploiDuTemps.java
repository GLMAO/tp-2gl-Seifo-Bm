package com.polytech.tp;

import java.util.ArrayList;
import java.util.List;

public class GestionnaireEmploiDuTemps implements Subject {
    private List<ICours> listeCours = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void ajouterCours(ICours cours) {
        this.listeCours.add(cours);
        System.out.println("Nouveau cours ajouté : " + cours.getDescription());
        notifyObservers("Nouveau cours ajouté : " + cours.getDescription());
    }

    public void modifierCours(ICours cours, String message) {
        System.out.println("Cours modifié : " + message);
        notifyObservers("Cours modifié : " + cours.getDescription() + " - " + message);
    }

    public void setChangement(String message) {
        System.out.println("Changement dans l'emploi du temps : " + message);
        // CORRECTION : Envoyer le message exact sans ajouter de préfixe
        notifyObservers(message);
    }

    public List<ICours> getListeCours() {
        return listeCours;
    }
}