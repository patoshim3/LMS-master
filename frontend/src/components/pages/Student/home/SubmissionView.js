import {useApi} from "../../../../helpers/hookes/useApi";
import {useAppMessage} from "../../../../providers/AppMessage";

import {useEffect, useState} from "react";
import {
    Avatar,
    Box,
    Card,
    CardContent, Chip, CircularProgress, ListItem, ListItemAvatar, ListItemText,
    Table,
    TableBody,
    TableCell,
    TableContainer,
    TableHead,
    TableRow,
    Typography
} from "@mui/material";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faPaperPlane, faTasks} from "@fortawesome/free-solid-svg-icons";
import Moment from "react-moment";

function ImageIcon() {
    return null;
}

function SubmissionView() {
    const api = useApi()
    const appMessage = useAppMessage();
    const [loading, setLoading] = useState();

    const [submissionData, setSubmissionData] = useState([]);

    const init = () => {
        setLoading(true);
        api.get('submission/my')
            .then((r) => {
                setSubmissionData(r.data);
            }).catch((e) => appMessage.notifyError(e)).finally(() => setLoading(false));
    }

    useEffect(() => {
        init()
    }, []);



    return (
        <Card sx={{minWidth: 275}} elevation={5}>
            <CardContent>
                <ListItem>
                    <ListItemAvatar>
                        <Avatar>
                            <FontAwesomeIcon icon={faPaperPlane}/>
                        </Avatar>
                    </ListItemAvatar>
                    <ListItemText primary="My Submission"/>
                </ListItem>
                <Box sx={{ width: '100%', overflow: 'hidden' }}>
                    <TableContainer sx={{ height: 440 }} component={Box}>
                        {
                            loading && (
                                <Box sx={{ display: 'flex', flexDirection: 'column', alignItems: 'center' }}>
                                    <CircularProgress />
                                </Box>
                            )
                        }
                        {
                            !loading &&

                            <Table sx={{minWidth: 650}} aria-label="simple table" stickyHeader>
                                <TableHead>
                                    <TableRow>
                                        <TableCell>Course</TableCell>
                                        <TableCell>Name</TableCell>
                                        <TableCell>Submitted Date</TableCell>
                                        <TableCell>Status</TableCell>
                                        <TableCell>Marked Date</TableCell>
                                        <TableCell>Comment</TableCell>
                                        <TableCell>Marks</TableCell>
                                    </TableRow>
                                </TableHead>
                                <TableBody>
                                    {submissionData.map((row) => (
                                        <TableRow
                                            key={row.id}
                                            sx={{'&:last-child td, &:last-child th': {border: 0}}}
                                        >
                                            <TableCell component="th" scope="row">
                                                {row.content.course.title}
                                            </TableCell>
                                            <TableCell component="th" scope="row">
                                                {row.content.name}
                                            </TableCell>
                                            <TableCell>
                                                <Moment parse="YYYY-MM-DD HH:mm">
                                                    {row.submittedDate}
                                                </Moment>

                                            </TableCell>
                                            <TableCell>
                                                {(!row.markedDate) &&
                                                <Chip label="Submitted for Marking...." color="info"/>}
                                                {(row.markedDate) && <Chip label="Marked" color="success"/>}
                                            </TableCell>
                                            <TableCell>
                                                <Moment parse="YYYY-MM-DD HH:mm">
                                                    {row.markedDate}
                                                </Moment>
                                            </TableCell>
                                            <TableCell>{row.comment ?? 'N/A'}</TableCell>
                                            <TableCell>{row.marks ?? 'N/A'}</TableCell>
                                        </TableRow>
                                    ))}
                                </TableBody>
                            </Table>
                        }
                    </TableContainer>
                </Box>
            </CardContent>
        </Card>
    );

}

export default SubmissionView;