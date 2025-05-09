import { CheckIcon } from "@/home/components/ui/CheckIcon";
import CardFeaturedArtists from "./CardFeaturedArtists";
import Button from "@/app/ui/Button";

const FeaturedArtists = () => {
  return (
    <section className="mx-auto mt-24 w-full">
      <h2 className="mx-6 my-12 text-start font-[roboto] text-[40px]">Artista destacado</h2>

      <CardFeaturedArtists />

      <div className=" mx-8 mt-8hidden h-18 w-36 lg:flex">
        <Button type="submit" className="rounded-l-none">
          <span className="flex items-center">
            <CheckIcon className="mr-2" />
            Ver más
          </span>
        </Button>
      </div>
    </section>
  );
};

export default FeaturedArtists;
