import java.util.ArrayList;

public class RepairSchedule
{
    /** Each element represents a repair by an individual mechanic in a bay. */
    private ArrayList<CarRepair> schedule;

    /** Number of mechanics available in this schedule. */
    private int numberOfMechanics;

    /** Constructs a RepairSchedule object.
     * Precondition: n >= 0
     */
    public RepairSchedule(int n)
    {
        /* to be implemented in part (a) */
        schedule = new ArrayList<>();
        numberOfMechanics = n;

    }

    public ArrayList<CarRepair> getSchedule()
    {
        return schedule;
    }

    /** Attempts to schedule a repair by a given mechanic in a given bay as described in part (a).
     * Precondition: 0 <= m < numberOfMechanics and b >= 0
     */
    public boolean addRepair(int m, int b)
    {
        /* to be implemented in part (b) */
        for (int i = 0; i < schedule.size(); i++){
            if (schedule.get(i).getMechanicNum() == m || schedule.get(i).getBayNum() == b){
                return false;
            }
        }
        CarRepair repair = new CarRepair(m,b);
        schedule.add(repair);
        return true; // STUB VALUE
    }

    /** Returns an ArrayList containing the mechanic identifiers of all available mechanics,
     * as described in part (b).
     */
    public ArrayList<Integer> availableMechanics()
    {
        /* to be implemented in part (c) */
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < numberOfMechanics; i++){
            boolean isFree = true;
            for (CarRepair x : schedule){
                if (x.getMechanicNum() == i){
                    isFree = false;
                }
            }
            if (isFree){
                list.add(i);
            }
        }

        return list; // STUB VALUE
    }

    /** Removes an element from schedule when a repair is complete. */
    public void carOut(int b)
    {
        for (int i = 0; i < schedule.size(); i++)
        {
            CarRepair carAtIdx = schedule.get(i);
            if (carAtIdx.getBayNum() == b)
            {
                schedule.remove(i);
            }
        }
    }
}