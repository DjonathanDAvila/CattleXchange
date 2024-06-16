import { CattleAdLink } from '../cattle-ad-link';

export interface CattleAdForBuyMinDTO {
  title: string;
  unitValue: number;
  quantity: number;
  ownerCod: string;
  cattleAdLink: CattleAdLink;
}
