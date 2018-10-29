export class Cartao{
    numero?: string;
    validade?: string;
    seguranca?: string;
    id_pessoa? = new Pessoa();
}

class Pessoa{
    id?: string;
    nome?: string;
    sobrenome?: string;
    email?: string;
    cpf?: string;
}