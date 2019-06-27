import { Customer } from './customer';

export interface Account{ 
    
    id:number; 
    type: Type;
    nickname: string; 
    rewards: number; 
    balance: number; 
    customer: Customer; 

}

export enum Type{
    Checking = 'CHECKING', 
    Savings = 'SAVINGS', 
    CREDIT = 'CREDIT'
    
}

