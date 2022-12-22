import { Request, Response } from "express";
import { user_adress_Repository } from "../repositories/user_adress_Repository";
import { user_info_Repository } from "../repositories/user_info_Repository";
import * as Joi from 'joi';

export class UserController{
    async addUser(req: Request, res: Response){
        

        const first_name = req.body.first_name;
        const last_name = req.body.last_name;
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
                first_name: Joi.string().required().empty(''),
                last_name: Joi.string().required().empty(''),
                cpf_user: Joi.string().required().empty(''),
                email_user: Joi.string().email().required().empty(''),
                password_user: Joi.string().required().empty(''),
                number_user: Joi.string().required().empty(''),
                bairro_user: Joi.string().required().empty(''),
                cep_user: Joi.string().required().empty(''),
                complemento_user: Joi.string().optional().empty(''),
                number_adress_user: Joi.string().required().empty(''),
                rua_user: Joi.string().required().empty('')
            })

            const valid  = formSchema.validate(req.body);
            if (valid.error) {
                for (const detail of valid.error.details) {
                    console.log(`O campo  ${detail.path} é obrigatorio`);
                    return res.status(404).json({message: 'Campos invalidos'})
                }
                } else {
                    const dataUserInfo = {
                        first_name,
                        last_name,
                        cpf_user,
                        email_user,
                        password_user,
                        number_user
                    }
                    const dataUserAdress = {
                        bairro_user,
                        cep_user,
                        complemento_user,
                        number_adress_user,
                        rua_user
                    }
                    
                    const newUserInfo = user_info_Repository.create(dataUserInfo);
                    const newUserAdress = user_adress_Repository.create(dataUserAdress);
                    
                    await user_info_Repository.save(newUserInfo);
                    await user_adress_Repository.save(newUserAdress);
                } 
        } catch (error) {
            console.log(error);
            return res.status(500).json({message: 'Internal Server Error'});
        }
    
    }
}