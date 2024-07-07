package com.example.crud.crud_app.util;

import java.lang.reflect.Field;

import org.springframework.stereotype.Component;

import com.example.crud.crud_app.model.Medicine;
import com.github.fge.jsonpatch.JsonPatch;

@Component
public class Patcher {
    public static void internPatcher(Medicine updatedData, JsonPatch patch) throws IllegalAccessException {

        //GET THE COMPILED VERSION OF THE CLASS
        Class<?> internClass= Medicine.class;
        Field[] internFields=internClass.getDeclaredFields();
        System.out.println(internFields.length);
        for(Field field : internFields){
            System.out.println(field.getName());
            //CANT ACCESS IF THE FIELD IS PRIVATE
            field.setAccessible(true);

            //CHECK IF THE VALUE OF THE FIELD IS NOT NULL, IF NOT UPDATE EXISTING INTERN
            Object value=field.get(patch);
            if(value!=null){
                field.set(updatedData,value);
            }
            //MAKE THE FIELD PRIVATE AGAIN
            field.setAccessible(false);
        }

    }

}