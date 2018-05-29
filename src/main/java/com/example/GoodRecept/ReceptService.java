package com.example.GoodRecept;

import java.util.List;

public interface ReceptService
{
    List<Recept> getRecepts();
    Recept findRecept(long id);
    Recept saveRecept(Recept recept);
    boolean	updateRecept(Recept recept);
    boolean	deleteRecept(long id);
}
