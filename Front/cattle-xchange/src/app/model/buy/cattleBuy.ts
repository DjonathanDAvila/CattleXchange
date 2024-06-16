import { Buyer } from "./buyer";
import { ItemBuy } from "./item-buy";

export interface CattleBuy {
  codBuy: string;
  dateBuy: string; // ou Date se preferir
  totalValue: number;
  buyer: Buyer;
  itemsBuy: ItemBuy[];
}
