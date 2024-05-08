import { Image } from "../image/image";
import { CattleAdStatus } from "./enum/cattleAdStatus";
import { Sex } from "./enum/sex";

export interface CattleAd {
  id: string;
  title: string;
  description?: string;
  unitValue: number;
  quantity: number;
  breed: string;
  sex: Sex;
  announcer: string;
  city: string;
  state: string;
  creationDate?: Date;
  status: CattleAdStatus;
  images: Image[];
}
