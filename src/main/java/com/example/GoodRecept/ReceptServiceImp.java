package com.example.GoodRecept;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class ReceptServiceImp implements ReceptService {
    private static List<Recept> recepts = new ArrayList<>();

     {
        recepts.add(new Recept(1, "Salad", "algo", "medium", "3 horas", "muchos ingre", "hacerlo"));
        recepts.add(new Recept(2, "pizza", "algo", "medium", "3 horas", "muchos ingre", "hacerlo"));
    }


    @Override
    public List<Recept> getRecepts() {
        return recepts;
    }

    @Override
    public Recept findRecept(long id) {
        Recept recept = null;

        for (Recept p : recepts) {
            if (p.getId() == id)
                recept = p;
        }

        return recept;
    }

    @Override
    public Recept saveRecept(Recept recept) {

          /*  for (int i =2; i<1; ++i) {
                recept.setId(i);
            }
    */
        recepts.add(recept);

        return recept;
    }

    @Override
    public boolean updateRecept(Recept recept) {
        boolean result = false;
        int index = 0;

        for (Recept p : recepts) {
            if (recept.getId() == p.getId()) {
                recepts.set(index, recept);

                result = true;
            }

            index++;
        }

        return result;
    }

    @Override
    public boolean deleteRecept(long id) {
        boolean result = false;
        int index = 0;

        for (Recept p : recepts) {
            if (id == p.getId())
                result = true;

            if (!result)
                index++;
        }

        recepts.remove(index);

        return result;
    }

}