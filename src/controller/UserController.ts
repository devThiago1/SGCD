import { Request, Response } from "express";
import { user_adress_Repository } from "../repositories/user_adress_Repository";
import { user_info_Repository } from "../repositories/user_info_Repository";
import * as Joi from 'joi';
import { User } from "./entities/User";
import { Adress } from "./entities/Adress";

export class UserController{
    async addUser(req: Request, res: Response){
        

        const first_name_user = req.body.first_name_user;
        const last_name_user = req.body.last_name_user;
        const cpf_user = req.body.cpf_user;
        const email_user = req.body.email_user;
        const password_user = req.body.password_user;
        const number_user = req.body.number_user;
        const bairro_user = req.body.bairro_user;
        const cep_user = req.body.cep_user;
        const complemento_user = req.body.complemento_user;
        const number_adress_user = req.body.number_adress_user;
        const rua_user = req.body.rua_user;

        try{
            const formSchema = Joi.object().keys({
                first_name_user: Joi.string().alphanum().min(3).max(30).required(),
                last_name_user: Joi.string().alphanum().min(3).max(30).required(),
                cpf_user: Joi.string().required(),
                email_user: Joi.string().email().required(),
                password_user: Joi.string().required().empty(''),
                number_user: Joi.string().required().empty(''),
                bairro_user: Joi.string().alphanum().min(3).max(30).required(),
                cep_user: Joi.string().required(),
                complemento_user: Joi.string().optional().empty(''),
                number_adress_user: Joi.string().required().empty(''),
                rua_user: Joi.string().required()
            })

            const valid  = formSchema.validate(req.body);
            if (valid.error) {
                for (const detail of valid.error.details) {
                    console.log(`O campo  ${detail.path} é obrigatorio`);
                    return res.status(404).json({message: 'Campos invalidos'})
                }
                } else {
            
                    const Address = new Adress();
                    Address.bairro_user = bairro_user;
                    Address.rua_user = rua_user;
                    Address.cep_user = cep_user;
                    Address.complemento_user = complemento_user;
                    Address.number_adress_user = number_adress_user;
                    await user_adress_Repository.manager.save(Address)
                    
                    const user = new User();
                    user.first_name_user = first_name_user;
                    user.last_name_user = last_name_user;
                    user.email_user = email_user;
                    user.password_user = password_user;
                    user.cpf_user = cpf_user;
                    user.number_user = number_user;
                    user.adress = Address;
                    await user_info_Repository.manager.save(user);

                    
                    
                    const allDataUser ={
                        first_name_user,
                        last_name_user,
                        cpf_user,
                        email_user,
                        password_user,
                        number_user,
                        bairro_user,
                        cep_user,
                        complemento_user,
                        number_adress_user,
                        rua_user
                    }
                    

                    return res.status(201).redirect('/sucessCadastro');
                } 
        } catch (error) {
            console.log(error);
            return res.status(500).json({message: 'Internal Server Error'});
        }
    
    }
}