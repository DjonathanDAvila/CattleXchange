import { CattleAdLink } from '../cattle-ad-link';

export interface CattleAdForBuyMinDTO {
  id: string;
  title: string;
  unitValue: number;
  quantity: number;
  ownerCod: string;
  cattleAdLink: CattleAdLink;
}
