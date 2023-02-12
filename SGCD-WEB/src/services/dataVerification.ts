import { request } from 'http';
import * as Joi from 'joi';


function dataVerification(newUser: any) {
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
    });
  
    const valid = formSchema.validate(newUser);
    if (valid.error) {
      for (const detail of valid.error.details) {
        console.log(`O campo ${detail.path} é obrigatório`);
        return false;
      }
    }else{
        return true;
    }
  }
  
  export default dataVerification;