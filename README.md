# Spring-Boot-Tasks

Built APIs based on spring boot framework.


## Table of Contents
- [Crud Application](#crud_app)
- [JWT Implementation](#jwt_implementation)


## Crud Application <a name = "crud_app"></a>


Description:<br/>
Demo Crud application based on spring boot framework. A medicine database is created and user can perform the CRUD (Create, Read, Update, Delete) operations on the db.

**Methods:**

- Get all medicines  (get)
endpoint: `/getAllMedicines`

SS: <img width="1007" alt="image" src="https://github.com/abhishek-bhatt-consultadd/crud-spring-boot/assets/174770106/7e42b60f-a365-4928-a3be-70c5869ed1cb">


- Get specific medicines (get)
endpoint: `/getMedicinebyId/{id}`

SS: <img width="1379" alt="image" src="https://github.com/abhishek-bhatt-consultadd/crud-spring-boot/assets/174770106/b114b31f-b867-47a4-b401-44ee1dd60d1d">


- Add medicines (post)
endpoint: `/addMedicines`

SS: <img width="999" alt="image" src="https://github.com/abhishek-bhatt-consultadd/crud-spring-boot/assets/174770106/63b587ff-ab73-466d-bc8f-a21ad2fea249">


- Update medicine (put)
endpoint: `/updateMedicine/{id}`

SS: <img width="998" alt="image" src="https://github.com/abhishek-bhatt-consultadd/crud-spring-boot/assets/174770106/a01691a9-4a33-4560-a6fd-b0f5ce87288b">


- Delete specific medicine (delete)
endpoint: `/deleteMedById/{id}`

SS: <img width="1012" alt="image" src="https://github.com/abhishek-bhatt-consultadd/crud-spring-boot/assets/174770106/767104de-2ccf-412d-9bc9-3084640183a9">


- Delete all medicines (delete)
endpoint: `/deleteAllMed`

SS: <img width="1001" alt="image" src="https://github.com/abhishek-bhatt-consultadd/crud-spring-boot/assets/174770106/d98f2948-48ba-477e-922a-ccd6f5266bfa">


- Update company (patch)
endpoint: `updateCompany/{id}`

SS: <img width="997" alt="image" src="https://github.com/abhishek-bhatt-consultadd/crud-spring-boot/assets/174770106/95e1929d-f403-46f2-9691-58d05002b591">

## JWT Implementation <a name = "jwt_implementation"></a>

1) User, Roles and user_roles tables are created.
2) Insert roles into the `roles` table
```
INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');
```
<img width="196" alt="image" src="https://github.com/abhishek-bhatt-consultadd/crud-spring-boot/assets/174770106/c0a5b806-edc3-4ae2-ae85-15dcedcede9c">

3) Register users for the roles

- Admin registeration
<img width="1121" alt="image" src="https://github.com/abhishek-bhatt-consultadd/crud-spring-boot/assets/174770106/e33df082-2f0f-41d5-bdf5-ce08ed7868a4">

- Mod registeration
<img width="1121" alt="image" src="https://github.com/abhishek-bhatt-consultadd/crud-spring-boot/assets/174770106/98e0af1d-7759-42bc-b122-4f6f93d441a5">

- User registeration
<img width="1121" alt="image" src="https://github.com/abhishek-bhatt-consultadd/crud-spring-boot/assets/174770106/ff8a8c14-c533-4ea8-84d4-db6806b56dd4">

- User registered in Db:
<img width="1121" alt="image" src="https://github.com/abhishek-bhatt-consultadd/crud-spring-boot/assets/174770106/c92ac64d-086f-4abf-abd6-4ebda34ce780">

4) Sign-in (Authentication)
<img width="1127" alt="image" src="https://github.com/abhishek-bhatt-consultadd/crud-spring-boot/assets/174770106/b4235acd-fc89-43ea-94c3-295361b5b1f2">

- Token is generated in cookies
<img width="1127" alt="image" src="https://github.com/abhishek-bhatt-consultadd/crud-spring-boot/assets/174770106/a21987e1-9f55-4c6e-995c-72f83497f120">





