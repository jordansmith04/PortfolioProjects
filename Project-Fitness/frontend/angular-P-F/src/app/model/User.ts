export class User{

    // private id:number; 
    private username:string;
    private pass:string;
    private ages:number;
    private heights:number;
    private weight:number;
    this: any;

    constructor(username:string, pass:string, ages:number, heights:number, weight:number){
        // this.id = id;
        this.username = username;
        this.pass = pass;
        this.ages = ages;
        this.heights = heights;
        this.weight = weight;
    }

    public getUsername():string{
        return this.username;
    }

    public setUsername(username:string){
        this.username = username;
    }

    public getPass():string{
        return this.pass;
    }

    public setPass(pass:string){
        this.pass = pass;
    }

    public getAge():number{
        return this.ages;
    }

    public setAge(ages:number){
        this.ages = ages;
    }

    public getHeight():number{
        return this.heights;
    }

    public setHeight(heights:number){
        this.heights = heights;
    }

    public getWeight():number{
        return this.weight;
    }

    public setWeight(weight:number){
        this.weight = weight;
    }

};

