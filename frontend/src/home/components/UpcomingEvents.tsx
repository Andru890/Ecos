import Button from "@/app/ui/Button";
import CardUpcomingEvents from "./CardUpcomingEvents";
import { CheckIcon } from "@/home/components/ui/CheckIcon";

const UpcomingEvents = () => {
  return (
    <section className="mt-24 w-full">
      <h2 className="m-8 text-start font-[roboto] text-[40px]">Próximos Eventos</h2>

      <CardUpcomingEvents />

      <div className="mx-auto mt-8 h-12 w-52">
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

export default UpcomingEvents;
