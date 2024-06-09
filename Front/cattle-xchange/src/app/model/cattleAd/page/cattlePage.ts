import { CattleAd } from "../cattle/cattleAd";
import { Pageable } from "./pageable";
import { Sort } from "./sort";

export interface CattleAdsPage {
  content: CattleAd[];
  pageable: Pageable;
  last: boolean;
  totalElements: number;
  totalPages: number;
  size: number;
  number: number;
  sort: Sort;
  first: boolean;
  numberOfElements: number;
  empty: boolean;
}
