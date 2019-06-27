
export class Withdrawl{ 

    id: number; 
    status: Status; 
    type: Type;
    medium: Medium;
    amount: number; 
    description: String;
}

export enum Status{ 
    
    Pending = 'PENDING', 
    Cancelled = 'CANCELLED', 
    Completed = 'COMPLETED'
}

export enum Type{ 
    P2p = 'P2P',
    Deposit = 'DEPOSIT',
    Withdrawl = 'WITHDRAWL'
}

export enum Medium{ 
    Balance = 'BALANCE', 
    Rewards = 'REWARDS'
}