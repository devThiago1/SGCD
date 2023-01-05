import {
    Entity,
    PrimaryGeneratedColumn,
    Column,
    OneToOne,
    JoinColumn,
} from "typeorm"
import { User } from "./User";

@Entity('adress')
export class Adress{

    @PrimaryGeneratedColumn()
    id:number;

    @Column({type: "text"})
    bairro_user: string;

    @Column({type: "text"})
    rua_user: string;
    
    @Column({type: "text"})
    complemento_user: string;

    @Column("varchar", { length: 11})
    cep_user: string;

    @Column("varchar", { length: 7})
    number_adress_user: number;    
}