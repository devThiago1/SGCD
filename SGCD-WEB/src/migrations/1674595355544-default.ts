import { MigrationInterface, QueryRunner } from "typeorm";

export class default1674595355544 implements MigrationInterface {
    name = 'default1674595355544'

    public async up(queryRunner: QueryRunner): Promise<void> {
        await queryRunner.query(`CREATE TABLE \`adress\` (\`id\` int NOT NULL AUTO_INCREMENT, \`bairro_user\` text NOT NULL, \`rua_user\` text NOT NULL, \`complemento_user\` text NOT NULL, \`cep_user\` varchar(11) NOT NULL, \`number_adress_user\` varchar(7) NOT NULL, PRIMARY KEY (\`id\`)) ENGINE=InnoDB`);
        await queryRunner.query(`CREATE TABLE \`users\` (\`id_user\` int NOT NULL AUTO_INCREMENT, \`first_name_user\` varchar(40) NOT NULL, \`last_name_user\` varchar(40) NOT NULL, \`number_user\` varchar(30) NOT NULL, \`cpf_user\` varchar(20) NOT NULL, \`email_user\` text NOT NULL, \`password_user\` text NOT NULL, \`adressId\` int NULL, UNIQUE INDEX \`REL_d668d60e6cbf1966636e32f4ef\` (\`adressId\`), PRIMARY KEY (\`id_user\`)) ENGINE=InnoDB`);
        await queryRunner.query(`ALTER TABLE \`users\` ADD CONSTRAINT \`FK_d668d60e6cbf1966636e32f4ef8\` FOREIGN KEY (\`adressId\`) REFERENCES \`adress\`(\`id\`) ON DELETE NO ACTION ON UPDATE NO ACTION`);
    }

    public async down(queryRunner: QueryRunner): Promise<void> {
        await queryRunner.query(`ALTER TABLE \`users\` DROP FOREIGN KEY \`FK_d668d60e6cbf1966636e32f4ef8\``);
        await queryRunner.query(`DROP INDEX \`REL_d668d60e6cbf1966636e32f4ef\` ON \`users\``);
        await queryRunner.query(`DROP TABLE \`users\``);
        await queryRunner.query(`DROP TABLE \`adress\``);
    }

}
